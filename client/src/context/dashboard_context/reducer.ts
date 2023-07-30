import * as constants from "./constants"
export const initialState = {
    years: [],
    sauceHistory: {
        dateFormat: [],
        total: [],
        filterBy: ""
    },
    total: {
        totalUpload: 0
    }
} as { years: datetimeSelectionType[], total: TotalUpload, sauceHistory:SauceHistoryProp};
export function dashboardReducer(state: dashboardReducerType, action: dashboardActionType<SauceHistoryProp & TotalUpload &  datetimeSelectionType[]>) {
    switch (action.type) {
        case constants.GET_TOAl:
            return {
                ...state,
                total: action.payload
            };
        case constants.GET_DASHBOARD:
            return {
                ...state,
                sauceHistory: action.payload
            };
        case constants.GET_YEAR:

            return {
                ...state,
                years: action.payload
            }
        default:
            return state;
    }
}