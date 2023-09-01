import axios from "axios";
import * as constants from "./constants";
import { headers } from "../../api/headerCommon";
import { base_url } from "../../context";

export async function login(dispatch: React.Dispatch<any>, form: LoginType) {
    const res = await axios.post(`${base_url}auth/login`, form, {
        headers: headers().default,
    });
    const tokens : responseType = res.data;
    if(tokens.accessToken && tokens.refreshToken){
        localStorage.setItem("accessToken", tokens.accessToken);
        document.cookie = `refreshToken=${tokens.refreshToken}; secure; path=/`;
        dispatch(setToken(tokens));
    }
}

export async function getNewAccessToken(dispatch: React.Dispatch<any>, refreshToken: string){
    const res = await axios.post(`${base_url}auth/refresh-token`,{refreshToken}, {
        headers: headers().default
    })
    const tokens : responseType = res.data;
    if(tokens.accessToken && tokens.refreshToken){
        localStorage.setItem("accessToken", tokens.accessToken);
        dispatch(setToken(tokens));
    }
}

export function logout(dispatch: React.Dispatch<any>) {
    dispatch(removeToken());
}

export async function register(dispatch: React.Dispatch<any>) {

}

function setToken(payload: AuthenticationType) {
    return {
        type: constants.SET_TOKEN,
        payload
    }
}
function removeToken() {
    return {
        type: constants.REMOVE_TOKEN,
    }
}