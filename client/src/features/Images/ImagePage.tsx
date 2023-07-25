import { Button, Modal } from "antd";
import { useState, useEffect } from "react";
import ImportModal from "./pages/ImportModal";
import axios from "axios";
import ImageList from "./pages/ImageList";

const ImagePage = () => {
    const [isOpen, setIsOpen] = useState<boolean>(false);
    const [images, setImages] = useState<ImageResponse[]>([]);
    useEffect(()=>{
        axios.get('http://localhost:8080/hentaibu/api/sauce/get-image', {
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Basic ${window.btoa("hentaibu:507c6e34b77b5916c3b791e2ff627114")}`
            }
        }).then(res =>{
            setImages(res.data);
        })
    },[])
    return (
        <>
            <div>
                <Button
                    type="primary"
                    style={{ float: "right" }}
                    onClick={() => setIsOpen(true)}
                >
                    Import Image
                </Button>
                <h2 style={{ display: "inline" }}>Image of this month</h2>
                <ImageList imageData={images}/>
            </div>
            <Modal title="Import Image"
                open={isOpen}
                onOk={() => setIsOpen(false)}
                onCancel={() => setIsOpen(false)}
                footer={false}
                bodyStyle={{ minHeight: "18rem" }}
                style={{ width: "100%", resize: "none" }}
            >
                <ImportModal/>
            </Modal>
        </>
    );
}

export default ImagePage;