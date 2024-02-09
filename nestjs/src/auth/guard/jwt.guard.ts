import { AuthGuard } from "@nestjs/passport";


// CLASS: JwtGuard
export class JwtGuard extends AuthGuard('jwt'){
    //  CONSTRUCTOR: JwtGuard
    constructor(){
        super();
        
    }
}