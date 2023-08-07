import * as constants from "./constants"

export const initialState: ImageResponse[] = [];

export function imageReducer(state: ImageResponse[], action: dashboardActionType<ImageResponse[] & ImageResponse>) {
    switch (action.type) {
        case constants.ADD_IMAGE:
            state = [...state, ...action.payload];
            return state;
        case constants.GET_IMAGES:
            state = action.payload;
            return state;
        case constants.REMOVE_IMAGE:
            const filter = state.filter(image => image.id != action.payload.id);
            return filter;
        default:
            return state;
    }
}