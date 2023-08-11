import {Row} from "antd";
import DisplayImages from "./DisplayImage";

const ImageList = ({ imageData }: { imageData: ImageResponse[] }) => {
  return (
    <>
      <div style={{ marginTop: 32 }}>
        <Row gutter={[8, 8]}>
          {imageData.map((image) => (
               <DisplayImages image={image} key={image.id}/> 
          ))}
        </Row>
      </div>
    </>
  );
};

export default ImageList;
