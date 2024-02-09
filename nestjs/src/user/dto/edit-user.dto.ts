import { IsOptional, IsEmail, IsString } from "class-validator";



// CLASS: EditUserDto
export class EditUserDto{
    @IsEmail()
    @IsOptional()
    email?: string;
    @IsString()
    @IsOptional()
    firstName?: string;
    @IsString() 
    @IsOptional()
    lastName?: string;


}