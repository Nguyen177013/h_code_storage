import { Modal } from "antd";
import { useState } from "react";

const ModalPage = () => {
    console.log("hi");
    const [toggleOpen, setOpen] = useState<boolean>(false);   
    return ( 
        <>
            <p style={{color:"red", cursor:"pointer"}}
            onClick={()=>setOpen(true)}
            >Click me :v</p>
            <Modal title="modal title" 
            open ={toggleOpen}
            onOk={()=>setOpen(false)} 
            onCancel={()=>setOpen(false)}
            >
                hello
            </Modal>
        </>
     );
}
 
export default ModalPage;