package com.trophy.servicepayment.model.resultcode;

public enum DefaultCode implements BaseCode {

    SUCCESS                 (0, "Success", "Thành công"),
    INVALID_SIGNATURE       (1, "invalid signature", "Lỗi hệ thống"),
    INVALID_ENCRYPT_DATA    (2, "Invalid encrypted data", "Lỗi hệ thống"),
    INVALID_USER_NAME       (3, "Invalid username", "Sai thông tin"),
    INVALID_WALLET_ID       (4, "Invalid wallet Id", "Sai thông tin ví"),
    INVALID_PASSWORD        (5, "Invalid password", "Sai Password"),
    INVALID_JSON_STRING     (6, "Invalid Json String", "Lỗi hệ thống"),
    INSUFFICIENT_FUNDS      (7, "Insufficient funds", "Ví không đủ hạn mức"),
    DUPLICATE_REQUEST_ID    (8, "Duplicate/Invalid request Id", "Trùng request ID"),
    INVALID_PARTNER_CODE    (9, "Invalid partner code", "Lỗi hệ thống"),
    UNKNOWN_RESULT          (10, "Unknown result. Please check manual to get final result", "Giao dịch đang trong quá trình xử lý"),
    OTHER_ERROR             (11, "Other Error", "Lỗi hệ thống"),
    OVER_LIMIT              (12, "Over limit tranaction", "Sai hạn mức giao dịch"),
    FUNCTION_NOT_ACTIVE     (13, "This function is not active. please contact the admininstrator", "Lỗi hệ thống"),
    ON_PROCESS              (14, "on process", "Dang thuc thi"),
    MAINTENANCE_SYSTEM      (15, "Mainternance system, please try later !", "Hệ thống đang bảo trì, vui lòng thử lại sau !"),
    CLASS_NOT_DEFINE        (16, "This class invalid contructor. please contact the admininstrator", "Lỗi hệ thống"),;


    private  int code;
    private  String message;
    private  String localMessage;

    private DefaultCode(int code, String message, String localMessage) {
        this.code = code;
        this.message = message;
        this.localMessage = localMessage;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getLocalMessage() {
        return this.localMessage;
    }
}
