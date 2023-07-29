import axios from "axios";
import * as constants from "./constants";
import { headers } from "../../api/headerCommon";

export async function getYear() {
    const closesYear = await axios.get("http://localhost:8080/hentaibu/api/sauce-history/get-year", {
        headers: headers
    });
    const date: [{ year: string }] = await closesYear.data;
    const years = date.map(year => ({
        value: year.year,
        label: year.year
    }));
    return setYear(years);
}
export async function getTotal() {
    const req = await axios.get("http://localhost:8080/hentaibu/api/sauce-history/get-total-upload", {
        headers: headers
    });
    const res: TotalUpload = await req.data;
    return setTotal(res);
}
export async function getDashBoard(year: string, option: string) {
    const req = await axios.get(`http://localhost:8080/hentaibu/api/sauce-history/get-history?year=${year}&dateUpload=${option}`, {
        headers: headers
    });
    const res : SauceHistory[] = req.data;
    const total = res.map(data => data.total);
    const date = res.map(data => {
        const number = data.dateFormat;
        if(number.toString().length === 4){
            return number.toString();
        }
        const monthName = new Intl.DateTimeFormat('en-US', { month: 'short' }).format(new Date(0, number - 1));
        return monthName;
    });
    const historyProp = {
        dateFormat: date,
        filterBy:"month",
        total:total
    } as SauceHistoryProp
    return setDashBoard(historyProp);
}

function setDashBoard(payload: SauceHistoryProp) {
    return {
        type: constants.GET_DASHBOARD,
        payload
    }
}

function setYear(payload: datetimeSelectionType[]) {
    return {
        type: constants.GET_DASHBOARD,
        payload
    }
}
function setTotal(payload: TotalUpload) {
    return {
        type: constants.GET_TOAl,
        payload
    }
}