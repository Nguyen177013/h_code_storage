import { CloseCircleTwoTone } from "@ant-design/icons";
import { Col, Image, Popconfirm } from "antd";
import axios from "axios";

const DisplayImages = ({ image }: { image: ImageResponse }) => {
  const handleDeleteImage = async () => {
    const req = await axios.delete(
      `http://localhost:8080/hentaibu/api/sauce/delete/${image.id}`,
      {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Basic ${window.btoa(
            "hentaibu:507c6e34b77b5916c3b791e2ff627114"
          )}`,
        },
      }
    );
    const res = await req.data;
    console.log(res);
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
