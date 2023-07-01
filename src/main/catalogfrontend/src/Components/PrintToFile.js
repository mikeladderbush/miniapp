import React from 'react';
import { saveAs } from 'file-saver';
import axios from 'axios';

function PrintToFile() {
    const handleDownload = async () => {
        try{ 
            const response = await axios.get("http://localhost:8080/api/user/miniatures")
            const fileContent = JSON.stringify(response.data)
            const blob = new Blob([fileContent], {type: 'text/plain;charset=utf-8'});
            saveAs(blob, 'MiniaturePortfolio.txt');
        } catch (error) {
            console.error('Error fetching data', error);
        }
    };

    return (
        <div>
            <button onClick={handleDownload}>Download Miniature Portfolio File</button>
        </div>
    );
}

export default PrintToFile;