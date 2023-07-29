type reducer<T> = {
    type: string,
    payload: T
}
type NewType = {
    years: datetimeSelectionType[]
    sauceHistory: SauceHistoryProp
    total: TotalUpload
}
type dashboardReducerType = NewType

type dashboardActionType = {
    type: string,
    payload:datetimeSelectionType[] | TotalUpload | SauceHistoryProp
}