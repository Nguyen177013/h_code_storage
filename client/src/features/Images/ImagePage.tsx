import { Button, Modal, Spin } from "antd";
import { useState, useEffect } from "react";
import ImportModal from "./pages/ImportModal";
import ImageList from "./pages/ImageList";
import {getImages} from "../../context/images_context/action";
import useImageContext from "../../hooks/useImage";
const ImagePage = () => {
  const [isOpen, setIsOpen] = useState<boolean>(false);
  const [pending, setPending] = useState<boolean>(false);
  const {dispatch, state} = useImageContext();
  useEffect(() => {
    getImages(dispatch);
  }, []);
  return (
    <>
      <Spin tip="Please wait..." spinning={pending} delay={200} style={{zIndex:99999999999}}>
        <div>
          <Button
            type="primary"
            style={{ float: "right" }}
            onClick={() => setIsOpen(true)}
          >
            Import Image
          </Button>
          <h2 style={{ display: "inline" }}>Image of this month</h2>
          <ImageList imageData={state} />
        </div>
        <Modal
          title="Import Image"
          open={isOpen}
          onOk={() => setIsOpen(false)}
          onCancel={() => setIsOpen(false)}
          footer={false}
          bodyStyle={{ minHeight: "18rem" }}
          style={{ width: "100%", resize: "none" }}
        >
          <ImportModal setPending={setPending} setIsOpen={setIsOpen}/>
        </Modal>
      </Spin>
    </>
  );
};

export default ImagePage;
