import {UserResource} from "~/ts/response.types";


export function convertToUser(userResource: UserResource) {
    return {
        id: userResource.id,
        firstName: userResource.firstName,
        lastName: userResource.lastName,
        dayOfBirth: userResource.dayOfBIrth,
        gender: userResource.gender,
        password: userResource.password,
        lastLogin: userResource.lastLogin,
        email: userResource.email
    };
}