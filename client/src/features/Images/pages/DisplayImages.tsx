import { Image } from "antd";

const DisplayImages = ({ images, url }: { images: File[], url: string }) => {
    return (
        <div style={{ display: "flex", justifyContent: "center", flexWrap: "wrap" }}>
            {
                images.map((image, index) => {
                    return (<span style={{ margin: 2 }} key={index}>
                        <Image src={URL.createObjectURL(image)} width={100} />
                    </span>)
                }
                )
            }
            {
                url && <span>
                    <Image src={url} width={100} />
                </span>
            }
        </div>
    );
}

export default DisplayImages;