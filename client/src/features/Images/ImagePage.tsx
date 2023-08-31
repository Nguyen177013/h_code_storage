import { Button, Modal, Space, Spin, Pagination } from "antd";
import { useState, useEffect } from "react";
import ImportModal from "./pages/ImportModal";
import ImageList from "./pages/ImageList";
import { getImages, setCurrentPage } from "../../context/images_context/action";
import useImageContext from "../../hooks/useImage";
import useAuthContext from "../../hooks/userAuth";
const ImagePage = () => {
  const { state: tokenState } = useAuthContext();
  const [isOpen, setIsOpen] = useState<boolean>(false);
  const [pending, setPending] = useState<boolean>(false);
  const { dispatch, state } = useImageContext();
  useEffect(() => {
    getImages(dispatch, 0, tokenState.accessToken);
  }, []);
  const handleChangePage = (page: number) => {
    getImages(dispatch, page - 1, tokenState.accessToken);
    dispatch(setCurrentPage(page - 1));
  };
  return (
    <>
      <Spin
        tip="Please wait..."
        spinning={pending}
        delay={200}
        style={{ zIndex: 99999999999 }}
      >
        <Space direction="vertical" size="large" style={{ display: "flex" }}>
          <div>
            <Button
              type="primary"
              style={{ float: "right" }}
              onClick={() => setIsOpen(true)}
            >
              Import Image
            </Button>
            <h2 style={{ display: "inline" }}>Image of this month</h2>
            <ImageList imageData={state.images} />
          </div>
          <div style={{ textAlign: "center" }}>
            {state.images.length > 0 && (
              <Pagination
                defaultCurrent={1}
                total={state.totalPage}
                defaultPageSize={12}
                onChange={handleChangePage}
              />
            )}
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
            <ImportModal setPending={setPending} setIsOpen={setIsOpen} />
          </Modal>
        </Space>
      </Spin>
    </>
  );
};

export default ImagePage;
