import { Injectable } from '@nestjs/common';
import { PrismaService } from '../prisma/prisma.service';
import { EditUserDto } from './dto';

@Injectable()
export class UserService {

//  CONSTRUCTOR: UserService
    constructor(private prisma: PrismaService) {
        
    }

    // FUNCTION: editUser
    async editUser(
        userId: number,
        dto: EditUserDto,
    ){
        const user = await this.prisma.user.update({
            where: { id: userId },
            data: {...dto},
        });
        delete user.hash;
        return user;
    }    
}
