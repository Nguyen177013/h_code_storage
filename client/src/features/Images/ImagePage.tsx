import { Button, Modal } from "antd";
import { useState } from "react";
import ImportModal from "./pages/ImportModal";

const ImagePage = () => {
    const [isOpen, setIsOpen] = useState<boolean>(false);
    return (
        <>
            <div>
                <h2 style={{ display: "inline" }}>Image of this month</h2>
                <Button
                    type="primary"
                    style={{ float: "right" }}
                    onClick={() => setIsOpen(true)}
                >
                    Import Image
                </Button>
            </div>
            <Modal title="Import Image"
                open={isOpen}
                onOk={() => setIsOpen(false)}
                onCancel={() => setIsOpen(false)}
                footer={false}
                bodyStyle={{ minHeight: "18rem" }}
                style={{ width: "100%", resize: "none" }}
            >
                <ImportModal/>
            </Modal>
        </>
    );
}

export default ImagePage;