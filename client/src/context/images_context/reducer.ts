import * as constants from "./constants"

export const initialState: ImageResponse[] = [];
export function ImageReducer(state:ImageResponse[], action:reducer<ImageResponse>){
    switch(action.type){
        case constants.ADD_IMAGE:
            return [...state, action.payload];
        case constants.GET_IMAGES:
            return state;
        case constants.REMOVE_IMAGE:
            const filter = state.filter(image=>image.id != action.payload.id);
            return filter;
    }
}