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
            return {
                ...state,
                refreshToken:action.payload.refreshToken,
                accessToken:action.payload.accessToken
            }
        case constants.REGISTER:
            return {
                ...state,
                refreshToken:action.payload.refreshToken,
                accessToken:action.payload.accessToken
            }
        case constants.LOGOUT:
            state.accessToken = "";
            state.refreshToken = "";
            return state;
        default:
            return state;
    }
}