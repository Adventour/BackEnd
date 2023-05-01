<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <!-- The Modal -->
            <div class="modal" id="modify">
              <div class="modal-dialog">
                <div class="modal-content">
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4>정보 수정</h4>
                  </div>

                  <!-- Modal body -->
                  <div class="modal-body">
                    <div class="col-lg-8 col-md-10 col-sm-12">
                      <form id="form-modify" method="POST" action="">
                        <input type="hidden" name="action" value="modify" />
                        <div class="mb-3">
                          <label for="name" class="form-label">이름 : </label>
                          <input
                            type="text"
                            class="form-control"
                            id="mname"
                            name="mname"
                            placeholder="이름..."
                            value="${userinfo.userName}"
                          />
                        </div>
                        <div class="mb-3">
                          <input
                            type="hidden"
                            class="form-control"
                            id="mid"
                            name="mid"
                            placeholder="아이디..."
                            value="${userinfo.userId}"
                          />
                        </div>
                        <div id="idcheck-result"></div>
                        <div class="mb-3">
                          <label for="pwd" class="form-label">변경할 비밀번호 : </label>
                          <input
                            type="password"
                            class="form-control"
                            id="mpwd"
                            name="mpwd"
                            placeholder="변경할 비밀번호..."
                          />
                        </div>
                        <div class="mb-3">
                          <label for="checkpwd" class="form-label">변경할 비밀번호 확인 : </label>
                          <input
                            type="password"
                            class="form-control"
                            id="mcheckpwd"
                            name="mcheckpwd"
                            placeholder="변경할 비밀번호 확인..."
                          />
                        </div>
                        <!-- <div class="mb-3">
                          <label for="email" class="form-label">이메일 : </label><br>
                          <input class="mb-3 span"
                            type="text"
                            class="form-control"
                            id="email1"
                            name="email1"
                            placeholder="이메일..."
                          />
                          <select class="mb-3 span" name="email2">
                            <option value="@ssafy.com" selected>싸피</option>
                            <option value="@naver.com" selected>네이버</option>
                            <option value="@gmail.com" selected>지메일</option>
                          </select>
                        </div> -->
                        <!-- <div class="mb-3">
                          <label for="location" class="form-label">지역 :</label><br>
                            <select id="sido" name="sido" class="form-select mb-3">
                              <option value="0" selected>시/도 선택</option>
                            </select>
                            <select id="gugun" name="gugun" class="form-select mb-3">
                              <option value="0" selected>구/군 선택</option>
                            </select>
                        </div> -->
                        <!-- <div class="text-danger mb-2">\${msg}</div> -->
                      </form>
                    </div>
                  </div>

                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <div class="col-auto text-center">
                      <button type="button" id="btn-modify" class="btn btn-outline-primary mb-3">
                        변경
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
          </li>
            <script>
            document.getElementById("btn-modify").addEventListener("click", function () {
              if (!document.querySelector("#mname").value) {
                alert("이름 확인!!");
                return;
              } else if (!document.querySelector("#mpwd").value) {
                alert("비밀번호 입력!!");
                return;
              } else if (document.querySelector("#mpwd").value != document.querySelector("#mcheckpwd").value) {
                alert("비밀번호 확인!!");
                return;
              } else {
                let form = document.getElementById("form-modify");
                form.setAttribute("action", "${root}/member");
                form.submit();
              }
            })
          </script>