import { CloseCircleTwoTone } from "@ant-design/icons";
import { Col, Image, Popconfirm } from "antd";
import { deleteImage } from "../../../context/images_context/action";
import useImageContext from "../../../hooks/useImage";

const DisplayImages = ({ image }: { image: ImageResponse }) => {
  const {dispatch, state} = useImageContext();
  const handleDeleteImage = async () => {
    await deleteImage(dispatch, image.id, state.currentPage);
  };
  return (
    <Col key={image.sauceUrl} span={4}>
      <div
        style={{
          border: "2px solid",
          boxSizing: "border-box",
          width: 200,
          height: 200,
          position: "relative",
        }}
      >
        <div style={{ width: "100%", height: "100%", overflow: "hidden" }}>
          <Image
            src={image.sauceUrl}
            style={{ objectFit: "cover", width: "100%", height: "100%" }}
            loading="lazy"
          />
        </div>
        <div style={{ position: "absolute", top: -18, right: -10 }}>
          <Popconfirm
            title="Delete this image"
            onConfirm={handleDeleteImage}
            okText="Yes"
            cancelText="No"
          >
            <CloseCircleTwoTone style={{ fontSize: 30 }} />
          </Popconfirm>
        </div>
      </div>
    </Col>
  );
};

export default DisplayImages;
