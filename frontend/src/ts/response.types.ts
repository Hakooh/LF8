// frontend models

export interface User {
    id: number;
    firstName: string;
    lastName: string;
    dayOfBirth: Date;
    gender: string;
    password: string;
    lastLogin: Date;
    email: string;

}




// backend models

export interface UserResource {
    id: number;
    firstName: string;
    lastName: string;
    dayOfBIrth: Date;
    gender: string;
    password: string;
    lastLogin: Date;
    email: string;
}

[{"id":1,
    "firstName":"Dieter",
    "lastName":"Detlefs",
    "dayOfBirth":"1986-04-20",
    "gender":"Male",
    "password": "password",
    "lastLogin":"2022-08-12",
    "email":"geilertyp@hotmail.de"}]