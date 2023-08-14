import axios from "axios";
import * as constants from "./constants"
import { ImageApi } from "../../enums/ImageEnums";
import { base_url } from "..";
import { headers } from "../../api/headerCommon";
export async function getImages(dispatch: React.Dispatch<any>, page: number = 0) {
    const req = await axios.get(`${base_url}sauce/get-all?sauceTypeId=9&page=${page}`, {
        headers: headers.jsonApplication
    });
    const res: PageType<ImageResponse> = await req.data;
    dispatch(getAllImage(res.content));
    dispatch(setTotalPage(res.totalElements));
}
export async function addImage<T>(dispatch: React.Dispatch<any>, data: T, type: string, currentPage: number) {
    let contentType = (type === ImageApi.ADD) ? headers.jsonApplication : headers.multiplePathFile;
    try {
        await axios.post(`${base_url}sauce/${type}`, data, {
            headers: contentType
        })
        getImages(dispatch, currentPage);
    }
    catch (ex) {
        const error = ex as Error;
        throw new Error(error.message);
    }
}
export async function deleteImage(dispatch: React.Dispatch<any>, imageId: number, currentPage: number) {
    try {

        await axios.delete(
            `${base_url}sauce/delete/${imageId}`,
            {
                headers: headers.jsonApplication
            }
        );
        dispatch(removeImage(imageId));
        getImages(dispatch, currentPage);
    } catch (bean) {
        console.log(bean);
    }
}
function getAllImage(payload: ImageResponse[]) {
    return {
        type: constants.GET_IMAGES,
        payload
    }
}
function setTotalPage(payload: number) {
    return {
        type: constants.GET_TOTAL_PAGE,
        payload
    }
}
export function setCurrentPage(payload: number) {
    return {
        type: constants.SET_CURRENT_PAGE,
        payload
    }
}
function removeImage(payload: number) {
    return {
        type: constants.REMOVE_IMAGE,
        payload
    }
}