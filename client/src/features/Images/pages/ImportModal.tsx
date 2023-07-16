import { Button, Input } from "antd";
import { useState } from "react";
import DisplayImages from "./DisplayImages";

const ImportModal = () => {
    const [imageInput, setImageInput] = useState<imageInput>({
      author: "",
      blob: [],
      url: ""
    });
  
    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
      const { name, value } = event.target;
      setImageInput(prevInput => ({
        ...prevInput,
        [name]: value
      }));
    };
  
    const handlePaste = (event: React.ClipboardEvent<HTMLDivElement>) => {
      const clipboardItems = Array.from(event.clipboardData.items).filter(
        item => /^image\//.test(item.type)
      );
  
      if (clipboardItems.length === 0) {
        return;
      }
  
      const item = clipboardItems[0];
      const blob = item.getAsFile();
      if (!blob) {
        return;
      }
  
      setImageInput(prevInput => ({
        ...prevInput,
        blob: [...prevInput.blob, blob]
      }));
    };
    return (
      <div onPaste={handlePaste}>
        <DisplayImages images ={imageInput.blob} url = {imageInput.url}/>
        <div>
          <h4 style={{ marginBottom: "10px" }}>You can Input Url Image</h4>
          <Input
            placeholder="Image author if exist"
            value={imageInput.author}
            style={{ width: "calc(50% - 24px )", margin: "0 3px" }}
            name="author"
            onChange={handleChange}
          />
          <Input
            placeholder="Image URL"
            value={imageInput.url}
            style={{ width: "calc(50% - 24px )", margin: "0 3px" }}
            name="url"
            onChange={handleChange}
          />
        </div>
        <div style={{ marginTop: "10px" }}>
            <Button style={{ marginTop: "10px" }} type="primary">
              Import
            </Button>
        </div>
      </div>
    );
  };
  
  export default ImportModal;
  