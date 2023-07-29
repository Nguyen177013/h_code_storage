import * as constants from "./constants"

export function getAllImage(payload:ImageResponse[]){
    return {
        type: constants.GET_IMAGES,
        payload
    }
}

export function getAddImage(payload:ImageResponse[]){
    return {
        type: constants.ADD_IMAGE,
        payload
    }
}
export function getRemoveImage(payload:ImageResponse[]){
    return {
        type: constants.REMOVE_IMAGE,
        payload
    }
}