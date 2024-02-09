import { ForbiddenException, Injectable } from "@nestjs/common";
import { PrismaService } from "../prisma/prisma.service";
import { AuthDto } from "./dto/auth.dto";
import * as argon from 'argon2';
import { PrismaClientKnownRequestError } from "@prisma/client/runtime/library";
import { JwtService } from "@nestjs/jwt";
import { ConfigService } from "@nestjs/config";

@Injectable()
export class AuthService {
    //  CONSTRUCTOR: AuthService
    constructor(
        private prisma: PrismaService,
        private jwt: JwtService,
        private config: ConfigService
        ) {}

    // FUNCTION: login
    async login(dto: AuthDto): Promise<{access_token: string}>  {
        const user = await this.prisma.user.findUnique({ where: { email: dto.email } });
        // if not found throw error
        if (!user) {
            throw new ForbiddenException('User not found');
        }

        // compare password
        if(!await argon.verify(user.hash, dto.password)) {
            throw new ForbiddenException('Password not match');
        }
        return this.signToken(user.id, user.email);
    }

    // FUNCTION: signup
    async signup(dto: AuthDto): Promise<{access_token: string}> {
        const hash = await argon.hash(dto.password);
        
        try {
            const user = await this.prisma.user.create({
                data: {
                    email: dto.email,
                    hash,
                }
            });
            return this.signToken(user.id, user.email);
        } catch (error) {
            if (error instanceof PrismaClientKnownRequestError) {
                if (error.code === 'P2002') {
                    throw new ForbiddenException('User already exists');
                }
            }
            throw error;
        }
    } 

    // FUNCTION: signToken
    async signToken(
        userId: number,
        email: string
        ): Promise<{access_token: string}>{
        const payload = {
             sub: userId,
             email 
            };
            const secret = this.config.get('JWT_SECRET');

        const token = await this.jwt.signAsync(
            payload,
            {
            expiresIn: '1h',
            secret: secret
            });
            return {access_token: token};   

    }


}