type ImageResponse = {
    authorId?: string,
    authorName?: string,
    sauceUrl: string,
    sauceImage: string,
    sauceType?:SauceType[]
    id: number | null
}
type imageInput = {
    author: string,
    blob: File[],
    url: string
}