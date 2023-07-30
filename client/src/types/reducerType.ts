type reducer<T> = {
    type: string,
    payload: T
}

type dashboardReducerType = {
    years: datetimeSelectionType[]
    sauceHistory: SauceHistoryProp
    total: TotalUpload
}

type dashboardActionType = {
    type: string,
    payload: SauceHistoryProp & TotalUpload &  datetimeSelectionType[]
}