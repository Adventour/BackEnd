<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <!-- The Modal -->
            <div class="modal" id="register">
              <div class="modal-dialog">
                <div class="modal-content">
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4>회원가입</h4>
                  </div>

                  <!-- Modal body -->
                  <div class="modal-body">
                    <div class="col-lg-8 col-md-10 col-sm-12">
                      <form id="form-register" method="POST" action="">
                        <input type="hidden" name="action" value="register" />
                        <div class="mb-3">
                          <label for="name" class="form-label">이름 : </label>
                          <input
                            type="text"
                            class="form-control"
                            id="rname"
                            name="rname"
                            placeholder="이름..."
                          />
                        </div>
                        <div class="mb-3">
                          <label for="id" class="form-label">아이디 : </label>
                          <input
                            type="text"
                            class="form-control"
                            id="rid"
                            name="rid"
                            placeholder="아이디..."
                          />
                        </div>
                        <div id="idcheck-result"></div>
                        <div class="mb-3">
                          <label for="pwd" class="form-label">비밀번호 : </label>
                          <input
                            type="password"
                            class="form-control"
                            id="rpwd"
                            name="rpwd"
                            placeholder="비밀번호..."
                          />
                        </div>
                        <div class="mb-3">
                          <label for="checkpwd" class="form-label">비밀번호 확인 : </label>
                          <input
                            type="password"
                            class="form-control"
                            id="rcheckpwd"
                            name="rcheckpwd"
                            placeholder="비밀번호 확인..."
                          />
                        </div>
                        <div class="mb-3">
                          <label for="email" class="form-label">이메일 : </label><br>
                          <input class="mb-3 span"
                            type="text"
                            class="form-control"
                            id="remail1"
                            name="remail1"
                            placeholder="이메일..."
                          />
                          <select class="mb-3 span" name="remail2">
                            <option value="@ssafy.com" selected>싸피</option>
                            <option value="@naver.com" selected>네이버</option>
                            <option value="@gmail.com" selected>지메일</option>
                          </select>
                        </div>
                        <div class="mb-3">
                          <label for="location" class="form-label">지역 :</label><br>
                            <select id="rsido" name="rsido" class="form-select mb-3">
                              <option value="0" selected>시/도 선택</option>
                            </select>
                            <select id="rgugun" name="rgugun" class="form-select mb-3">
                              <option value="0" selected>구/군 선택</option>
                            </select>
                        </div>
                        <!-- <div class="text-danger mb-2">\${msg}</div> -->
                      </form>
                    </div>
                  </div>

                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <div class="col-auto text-center">
                      <button type="button" id="btn-register" class="btn btn-outline-primary mb-3">
                        회원가입
                      </button>
                      <button
                        type="button"
                        class="btn btn-outline-primary mb-3"
                        data-dismiss="modal"
                      >
                        취소
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          <script>
          let isUseId = false;
          document.querySelector("#rid").addEventListener("keyup", function () {
            let userid = this.value;
            console.log(userid);
            let resultDiv = document.querySelector("#idcheck-result");
            if(userid.length < 6 || userid.length > 16) {
              resultDiv.setAttribute("class", "mb-3 text-dark");
              resultDiv.textContent = "아이디는 6자 이상 16자 이하 입니다.";
              isUseId = false;
            } else {
              fetch("${root}/member?action=idcheck&userid=" + userid)
              .then(response => response.text())
              .then(data => {
                if(data == 0) {
                  resultDiv.setAttribute("class", "mb-3 text-primary");
                  resultDiv.textContent = userid + "는 사용할 수 있습니다.";
                  isUseId = true;
                } else {
                  resultDiv.setAttribute("class", "mb-3 text-danger");
                  resultDiv.textContent = userid + "는 사용할 수 없습니다.";
                  isUseId = false;
                }
              });
            }
          });
       

          </script>
          <script>
            document.getElementById("btn-register").addEventListener("click", function () {
           	  var id = document.querySelector("#rid").value;
           	  console.log(document.querySelector("#rid").value);
           	  console.log(document.querySelector("#rname").value);
           	  console.log(document.querySelector("#rpwd").value);
           	  console.log(document.querySelector("#remail1").value);
           	  console.log(document.querySelector("#rsido").value);
              if (!document.querySelector("#rname").value) {
                alert("이름 확인!!");
                return;
              } else if (!id) {
                alert("아이디 확인!!");
                return;
              } else if (!document.querySelector("#rpwd").value) {
           	    alert("비밀번호 입력!!");
                return;
              } else if (document.querySelector("#rpwd").value != document.querySelector("#rcheckpwd").value) {
                alert("비밀번호가 다릅니다!!");
                return;
              } else if (!document.querySelector("#remail1").value) {
                alert("이메일 확인!!");
              } else if (document.querySelector("#rsido").value == 0 || document.querySelector("#rgugun").value == 0){
                alert("지역 확인!!");
              } else {
                let form = document.getElementById("form-register");
                form.setAttribute("action", "${root}/member");
                form.submit();
              }
            })
          </script>