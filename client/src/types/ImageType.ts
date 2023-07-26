type ImageResponse = {
    authorId?: string,
    authorName?: string,
    sauceUrl: string,
    sauceImage: string,
    id: number
}
type imageInput = {
    author: string,
    blob: File[],
    url: string
}