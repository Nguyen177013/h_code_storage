import { Col, Image, Row } from "antd";

const ImageList = ({imageData}: {imageData:ImageResponse[]}) => {
    return ( 
        <>
        <div style={{marginTop:32}}>
            <Row gutter={[8,8]}>
                {imageData.map(image =>(
                    <Col key={image.sauceUrl} span={4}>
                        <Image src={image.sauceUrl} style={{width:200, height:200, objectFit:"cover"}}/>
                     </Col>
                ))}
                <Col span={4}>
                        <Image style={{width:200, height:200,objectFit:"cover"}} src="https://i.pximg.net/img-original/img/2023/07/21/18/57/06/110109601_p0.jpg"/>
                </Col>
                <Col span={4}>
                        <Image style={{width:200, height:200,objectFit:"cover"}} src="https://i.pximg.net/img-original/img/2023/07/21/18/57/06/110109601_p0.jpg"/>
                </Col>
                <Col span={4}>
                        <Image style={{width:200, height:200,objectFit:"cover"}} src="https://cdn.discordapp.com/attachments/1079278724853268490/1127602604235575328/image.png"/>
                </Col>
                <Col span={4}>
                        <Image style={{width:200, height:200,objectFit:"cover"}} src="https://cdn.discordapp.com/attachments/752420410959855639/1132022108558467244/90806666_p0.png"/>
                </Col>
                <Col span={4}>
                        <Image style={{width:200, height:200,objectFit:"cover"}} src="https://cdn.discordapp.com/attachments/752420410959855639/1132227796551340052/361228428_799490281817799_3337786349299504064_n.png"/>
                </Col>
                <Col span={4}>
                        <Image style={{width:200, height:200,objectFit:"cover"}} src="https://cdn.discordapp.com/attachments/752420410959855639/1130186120605483139/361570960_796655408767953_7621132010102090398_n.png"/>
                </Col>
            </Row>
        </div>
        </>
     );
}
 
export default ImageList;