export function fileReduce(file: File) {
    const blobURL = window.URL.createObjectURL(file);
    const img = new Image();
    img.src = blobURL.toString();
    let resultFile = null
    img.onload = function () {
        const canvas = document.createElement("canvas");
        canvas.width = img.width;
        canvas.height = img.height;

        const imageType = file.type;
        const ctx = canvas.getContext("2d");
        ctx?.drawImage(img, 0, 0);
        canvas.toBlob(blob => {
            if(blob)
            resultFile = new File([blob], file.name);
        }, imageType);
    }
}