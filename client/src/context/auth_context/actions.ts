import axios from "axios";
import * as constants from "./constants";
import { headers } from "../../api/headerCommon";
import { base_url } from "../../context";

export async function login(dispatch: React.Dispatch<any>, form: LoginType) {
    const res = await axios.post(`${base_url}auth/login`, form, {
        headers: headers.jsonApplication,
    });
    const tokens : responseType = res.data;
    if(tokens.accessToken && tokens.refreshToken){
            localStorage.setItem("accessToken", tokens.accessToken);
            document.cookie = `refreshToken=${tokens.refreshToken}; secure; path=/`;
            dispatch(setLogin(tokens));
    }
}

export async function logout(dispatch: React.Dispatch<any>) {

}

export async function register(dispatch: React.Dispatch<any>) {

}

function setLogin(payload: AuthenticationType) {
    return {
        type: constants.LOGIN,
        payload
    }
}

function setLogout(payload: AuthenticationType) {
    return {
        type: constants.LOGIN,
        payload
    }
}

function setRegister() {
    return {
        type: constants.LOGIN,
    }
}