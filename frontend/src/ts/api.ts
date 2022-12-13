import axios, {AxiosResponse} from 'axios';
import {User, UserResource} from "~/ts/response.types";
import {convertToUser} from "~/ts/converters/userConverter";


const BASE_URL = 'http://localhost:8080/api/user/'

export async function getAllUsers() {
    const url = BASE_URL + 'all'
    console.log(url)

    let list={}

    return axios
        .get(url)
        .then(function(result) {
            console.log(result);

            list = result.data;
            console.log(list)
        });

}