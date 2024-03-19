const deleteBtn = document.querySelector("#deleteBtn");

deleteBtn.addEventListener("click", e => {

  if(confirm("삭제 하시겠습니까?")){
    location.href = `/music/delete?musicNo=${e.target.dataset.musicNo}`;
  }

});