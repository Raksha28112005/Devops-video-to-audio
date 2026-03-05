document.getElementById("uploadForm").addEventListener("submit", async function(e){

    e.preventDefault();

    let fileInput = document.getElementById("fileInput");

    if(fileInput.files.length === 0){
        alert("Please select a video file");
        return;
    }

    let formData = new FormData();
    formData.append("file", fileInput.files[0]);

    try{

        let response = await fetch("/convert",{
            method:"POST",
            body:formData
        });

        if(!response.ok){
            alert("Conversion failed");
            return;
        }

        let blob = await response.blob();

        let downloadUrl = window.URL.createObjectURL(blob);

        let a = document.createElement("a");
        a.href = downloadUrl;
        a.download = "audio.mp3";

        document.body.appendChild(a);
        a.click();

        a.remove();

    }catch(error){
        console.error(error);
        alert("Error occurred during conversion");
    }

});