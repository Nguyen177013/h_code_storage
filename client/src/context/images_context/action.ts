import axios from "axios";
import * as constants from "./constants"
import { ImageApi } from "../../enums/ImageEnums";
import { base_url } from "..";
import { headers } from "../../api/headerCommon";
export async function getImages(dispatch: React.Dispatch<any>, page: number = 0, accessToken: string) {
    const req = await axios.get(`${base_url}sauce/get-all?sauceTypeId=9&page=${page}`, {
        headers: headers(accessToken).jsonApplication
    });
    const res: PageType<ImageResponse> = await req.data;
    dispatch(getAllImage(res.content));
    dispatch(setTotalPage(res.totalElements));
}
export async function addImage<T>(dispatch: React.Dispatch<any>, data: T, type: string, currentPage: number, accessToken: string) {
    let contentType = (type === ImageApi.ADD) ? headers(accessToken).jsonApplication : headers(accessToken).multiplePathFile;
    try {
        await axios.post(`${base_url}sauce/${type}`, data, {
            headers: contentType
        })
        getImages(dispatch, currentPage, accessToken);
    }
    catch (ex) {
        const error = ex as Error;
        throw new Error(error.message);
    }
}
export async function deleteImage(dispatch: React.Dispatch<any>, imageId: number, currentPage: number, accessToken: string) {
    try {

        await axios.delete(
            `${base_url}sauce/delete/${imageId}`,
            {
                headers: headers(accessToken).jsonApplication
            }
        );
        dispatch(removeImage(imageId));
        getImages(dispatch, currentPage, accessToken);
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