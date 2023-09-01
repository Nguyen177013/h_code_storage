import * as constants from "./constants"

const accessTokenJSON = localStorage.getItem('accessToken');
const accessToken = accessTokenJSON != null ? accessTokenJSON : "";
const refreshToken = document.cookie != "" ? document.cookie.split("=")[1] : "";
export const initialState = {
    accessToken: accessToken,
    refreshToken: refreshToken
} as AuthenticationType;

export function authenticateReducer(state: AuthenticationType, action: dashboardActionType<AuthenticationType>) {
    switch (action.type) {
        case constants.SET_TOKEN:
            console.log("hi");
            
            return {
                ...state,
                refreshToken: action.payload.refreshToken,
                accessToken: action.payload.accessToken
            }
        case constants.REMOVE_TOKEN:
            return {
                ...state,
                refreshToken: "",
                accessToken: ""
            };
        default:
            return state;
    }
}