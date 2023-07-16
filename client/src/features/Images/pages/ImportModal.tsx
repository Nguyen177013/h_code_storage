import { Button, Image, Input } from "antd";
import { useState } from "react";

const ImportModal = () => {
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
    const handlePaste = (e: React.ClipboardEvent<HTMLDivElement>) => {
        const clipboardItems = e.clipboardData.items;
        const items = Array.from(clipboardItems).filter(function (item) {
            return /^image\//.test(item.type);
        });
        if (items.length === 0) {
            return;
        }
        const item = items[0];
        const blob = item.getAsFile();
        if (!blob) {
            return;
        }
        setImageInput(preInput => ({
            ...preInput,
            "url": URL.createObjectURL(blob)
        }));
    }
    return (
        <div onPaste={handlePaste}>
            <div style={{ display: "flex", justifyContent: "center" }}>
                <Image src={imageInput?.url} width={200} />
            </div>
            <div>
                <h4 style={{ marginBottom: "10px" }}>You can Input Url Image</h4>
                <Input
                    placeholder="Image author if exist"
                    value={imageInput?.author}
                    style={{ width: "calc(50% - 24px )", margin: "0 3px" }}
                    name="author"
                    onChange={handleChange} />
                <Input
                    placeholder="Image URL"
                    value={imageInput?.url}
                    style={{ width: "calc(50% - 24px )", margin: "0 3px" }}
                    name="url"
                    onChange={handleChange} />
            </div>
            <div style={{ marginTop: "10px" }}>
                <h4>Or import image file</h4>
                <Button style={{ marginTop: "10px" }} type="primary">Import</Button>
            </div>
        </div>
    );
}

export default ImportModal;