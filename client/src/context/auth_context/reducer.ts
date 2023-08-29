import * as constants from "./constants"

const accessTokenJSON = localStorage.getItem('accessToken');
const accessToken = accessTokenJSON !=null ? accessTokenJSON : "";
const refreshToken = document.cookie !="" ? document.cookie.split(":")[0] : "";
export const initialState = {
    accessToken: accessToken,
    refreshToken: refreshToken
} as AuthenticationType;

export function authenticateReducer(state: AuthenticationType, action: dashboardActionType<AuthenticationType>){
    switch(action.type){
        case constants.LOGIN:
            state.accessToken = action.payload.accessToken;
            state.refreshToken = action.payload.refreshToken;
            return state;
        case constants.REGISTER:
            state.accessToken = action.payload.accessToken;
            state.refreshToken = action.payload.refreshToken;
            return state;
        case constants.LOGOUT:
            state.accessToken = "";
            state.refreshToken = "";
            return state;
        default:
            return state;
    }
}