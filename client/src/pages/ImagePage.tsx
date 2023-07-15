import { Button, Input, Modal } from "antd";
import { useState } from "react";

const ImagePage = () => {
    const [isOpen, setIsOpen] = useState<boolean>(false);
    const [imageInput, setImageInput] = useState<imageInput>({
        author: "",
        url: ""
    });
    const handleChange = (event: React.FormEvent<HTMLInputElement>) => {
        const name = ((event.target as HTMLInputElement).name);
        const value = ((event.target as HTMLInputElement).value);
        setImageInput(preInput => ({
            ...preInput,
            [name]: value
        }));
    }
    return (
        <>
            <div>
                <h2 style={{ display: "inline" }}>Image of this month</h2>
                <Button
                    type="primary"
                    style={{ float: "right" }}
                    onClick={() => setIsOpen(true)}
                >
                    Import Image
                </Button>
                <Modal title="Import Image"
                    open={isOpen}
                    onOk={() => setIsOpen(false)}
                    onCancel={() => setIsOpen(false)}
                    footer={false}
                    bodyStyle={{ height: "18rem" }}
                >
                    <div>
                        <h4 style={{ marginBottom: "10px" }}>You can Input Url Image</h4>
                        <Input
                            placeholder="Image author if exist"
                            value={imageInput?.author}
                            style={{ width: "calc(50% - 24px )", margin: "0 3px" }}
                            name="author"
                            onChange={handleChange} />
                        <Input
                            placeholder="Image author if exist"
                            value={imageInput?.url}
                            style={{ width: "calc(50% - 24px )", margin: "0 3px" }}
                            name="url"
                            onChange={handleChange} />
                    </div>
                    <div style={{ marginTop: "10px" }}>
                        <h4>Or import image file</h4>
                        <Button style={{ marginTop: "10px" }} type="primary">Import</Button>
                    </div>
                </Modal>
            </div>

        </>
    );
}

export default ImagePage;