import * as constants from "./constants"
type imageReduce = {
    images: ImageResponse[],
    totalPage: number
}
export const initialState: imageReduce = {
    images: [],
    totalPage: 0
};

export function imageReducer(state: imageReduce, action: dashboardActionType<ImageResponse[] & ImageResponse & number>) {
    switch (action.type) {
        case constants.ADD_IMAGE:
            state = {
                ...state,
                images: [...action.payload, ...state.images]
            }
            return state;
        case constants.GET_IMAGES:
            state = {
                ...state,
                images: action.payload
            }
            return state;
        case constants.GET_TOTAL_PAGE:
            state = {
                ...state,
                totalPage: action.payload
            }
            return state;
        case constants.REMOVE_IMAGE:
            const filter = state.images.filter(map => map.id !== action.payload);
            state = {
                ...state,
                images: filter
            }
            return state;
        default:
            return state;
    }
}