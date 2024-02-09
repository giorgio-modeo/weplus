import { Module } from '@nestjs/common';
import { AuthController } from './auth.controller'; 
import { AuthService } from './auth.service';
import { JwtModule } from '@nestjs/jwt';
import { JwtStrategy } from './strategy';


@Module({
    controllers: [AuthController ],
    providers: [AuthService,JwtStrategy],
    imports: [JwtModule.register({})]
//  questo codice non è necessario perchè utilizzo prismisma
//  adesso la stringa di connessione è .env
    // imports: [
    //     TypeOrmModule.forRoot({
    //             type: 'mysql',
    //             host: 'localhost',
    //             port: 3306,
    //             username: 'root',
    //             password: '',
    //             database: 'nest_tutorial',
    //             entities: [],
    //             synchronize: true,
    //         })
    // ]
})
export class AuthModule{}