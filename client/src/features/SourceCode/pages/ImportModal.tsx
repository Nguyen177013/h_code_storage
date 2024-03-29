import { Button, Input } from "antd";
import { useState } from "react";
import DisplayImages from "./DisplayModalImages";
import { addImage } from "../../../context/images_context/action";
import useImageContext from "../../../hooks/useImage";
import { fileReduce } from "../../../utils/fileReduce";

const staticFileSize = 10485760;
const ImportModal = ({
  setPending,
  setIsOpen,
}: {
  setPending: (status: boolean) => void;
  setIsOpen: (status: boolean) => void;
}) => {
  const { dispatch, state } = useImageContext();
  const [imageInput, setImageInput] = useState<imageInput>({
    author: "",
    blob: [],
    url: "",
  });
  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setImageInput((prevInput) => ({
      ...prevInput,
      [name]: value,
    }));
  };
  const handlePaste = (event: React.ClipboardEvent<HTMLDivElement>) => {
    const clipboardItems = Array.from(event.clipboardData.items).filter(
      (item) => /^image\//.test(item.type)
    );

    if (clipboardItems.length === 0) {
      return;
    }

    const item = clipboardItems[0];
    const blob = item.getAsFile();
    if (!blob) {
      return;
    }

    setImageInput((prevInput) => ({
      ...prevInput,
      blob: [...prevInput.blob, blob],
    }));
  };

  const handleImport = async () => {
    setPending(true);
    const formData = new FormData();
    const { blob, url } = imageInput;
    if (blob.length === 0 && url === "") {
      return;
    }
    for (let file of blob) {
      if (file.size > staticFileSize) {
        const blob = await fileReduce(file);
        const fileReturn = new File([blob], file.name, {
          type: blob.type,
        });
        formData.append(`files`, fileReturn, file.name);
      } else {
        formData.append(`files`, file, file.name);
      }
    }
    addImage(dispatch, formData, state.currentPage).then(() => {
      setPending(false);
      setIsOpen(false);
      setImageInput({
        author: "",
        blob: [],
        url: "",
      });
    });
  };
  return (
    <div onPaste={handlePaste}>
      <DisplayImages images={imageInput.blob} url={imageInput.url} />
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
        <Button
          style={{ marginTop: "10px" }}
          type="primary"
          onClick={() => handleImport()}
        >
          Import
        </Button>
      </div>
    </div>
  );
};

export default ImportModal;
