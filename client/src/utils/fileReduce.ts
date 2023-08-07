export async function fileReduce(file: File): Promise<Blob> {
    const imageBitmap = await createImageBitmap(file);
    const canvas = document.createElement('canvas');
    canvas.width = imageBitmap.width;
    canvas.height = imageBitmap.height;
    const ctx = canvas.getContext('2d');
    ctx?.drawImage(imageBitmap, 0, 0);
    return await new Promise((resolve: any) => {
        canvas.toBlob(resolve, "image/jpeg",1);
    });
}
