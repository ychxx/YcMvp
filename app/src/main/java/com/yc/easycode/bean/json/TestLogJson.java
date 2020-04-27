package com.yc.easycode.bean.json;

/**
 *
 */
public class TestLogJson {

    /**
     * msg : 调用成功
     * returnCode : 1
     * apiMethod : /login
     * subCode : 10
     * subMsg : 成功
     * account : {"accountId":250,"accountName":"hckj2018","auth":{"alarmAuth":{"info":{"select":true,"setRead":true}},"deviceAuth":{"decoder":{"channelAdd":true,"channelSelect":true,"channelStop":true,"select":true},"ipc":{"cloudVideo":true,"localVideo":true,"preview":true,"ptzCruise":true,"ptzCtrl":true,"ptzPreset":true,"select":true,"update":true}},"districtAuth":{"device":{"move":true,"select":true},"node":{"create":true,"delete":true,"move":true,"select":true,"update":true}}},"cityCode":"","countryCode":"","deviceQty":14810,"email":"","lastLoginTimeString":"2019-08-29 16:12:55","orgCode":"100","orgName":"总部","provinceCode":"","realName":"汇川科技"}
     * token : 9f04c8f516588ead14d93e565142b362
     */

    private String msg;
    private String returnCode;
    private String apiMethod;
    private String subCode;
    private String subMsg;
    private AccountBean account;
    private String token;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class AccountBean {
        /**
         * accountId : 250
         * accountName : hckj2018
         * auth : {"alarmAuth":{"info":{"select":true,"setRead":true}},"deviceAuth":{"decoder":{"channelAdd":true,"channelSelect":true,"channelStop":true,"select":true},"ipc":{"cloudVideo":true,"localVideo":true,"preview":true,"ptzCruise":true,"ptzCtrl":true,"ptzPreset":true,"select":true,"update":true}},"districtAuth":{"device":{"move":true,"select":true},"node":{"create":true,"delete":true,"move":true,"select":true,"update":true}}}
         * cityCode :
         * countryCode :
         * deviceQty : 14810
         * email :
         * lastLoginTimeString : 2019-08-29 16:12:55
         * orgCode : 100
         * orgName : 总部
         * provinceCode :
         * realName : 汇川科技
         */

        private int accountId;
        private String accountName;
        private AuthBean auth;
        private String cityCode;
        private String countryCode;
        private int deviceQty;
        private String email;
        private String lastLoginTimeString;
        private String orgCode;
        private String orgName;
        private String provinceCode;
        private String realName;

        public int getAccountId() {
            return accountId;
        }

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public AuthBean getAuth() {
            return auth;
        }

        public void setAuth(AuthBean auth) {
            this.auth = auth;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public int getDeviceQty() {
            return deviceQty;
        }

        public void setDeviceQty(int deviceQty) {
            this.deviceQty = deviceQty;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLastLoginTimeString() {
            return lastLoginTimeString;
        }

        public void setLastLoginTimeString(String lastLoginTimeString) {
            this.lastLoginTimeString = lastLoginTimeString;
        }

        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public static class AuthBean {
            /**
             * alarmAuth : {"info":{"select":true,"setRead":true}}
             * deviceAuth : {"decoder":{"channelAdd":true,"channelSelect":true,"channelStop":true,"select":true},"ipc":{"cloudVideo":true,"localVideo":true,"preview":true,"ptzCruise":true,"ptzCtrl":true,"ptzPreset":true,"select":true,"update":true}}
             * districtAuth : {"device":{"move":true,"select":true},"node":{"create":true,"delete":true,"move":true,"select":true,"update":true}}
             */

            private AlarmAuthBean alarmAuth;
            private DeviceAuthBean deviceAuth;
            private DistrictAuthBean districtAuth;

            public AlarmAuthBean getAlarmAuth() {
                return alarmAuth;
            }

            public void setAlarmAuth(AlarmAuthBean alarmAuth) {
                this.alarmAuth = alarmAuth;
            }

            public DeviceAuthBean getDeviceAuth() {
                return deviceAuth;
            }

            public void setDeviceAuth(DeviceAuthBean deviceAuth) {
                this.deviceAuth = deviceAuth;
            }

            public DistrictAuthBean getDistrictAuth() {
                return districtAuth;
            }

            public void setDistrictAuth(DistrictAuthBean districtAuth) {
                this.districtAuth = districtAuth;
            }

            public static class AlarmAuthBean {
                /**
                 * info : {"select":true,"setRead":true}
                 */

                private InfoBean info;

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public static class InfoBean {
                    /**
                     * select : true
                     * setRead : true
                     */

                    private boolean select;
                    private boolean setRead;

                    public boolean isSelect() {
                        return select;
                    }

                    public void setSelect(boolean select) {
                        this.select = select;
                    }

                    public boolean isSetRead() {
                        return setRead;
                    }

                    public void setSetRead(boolean setRead) {
                        this.setRead = setRead;
                    }
                }
            }

            public static class DeviceAuthBean {
                /**
                 * decoder : {"channelAdd":true,"channelSelect":true,"channelStop":true,"select":true}
                 * ipc : {"cloudVideo":true,"localVideo":true,"preview":true,"ptzCruise":true,"ptzCtrl":true,"ptzPreset":true,"select":true,"update":true}
                 */

                private DecoderBean decoder;
                private IpcBean ipc;

                public DecoderBean getDecoder() {
                    return decoder;
                }

                public void setDecoder(DecoderBean decoder) {
                    this.decoder = decoder;
                }

                public IpcBean getIpc() {
                    return ipc;
                }

                public void setIpc(IpcBean ipc) {
                    this.ipc = ipc;
                }

                public static class DecoderBean {
                    /**
                     * channelAdd : true
                     * channelSelect : true
                     * channelStop : true
                     * select : true
                     */

                    private boolean channelAdd;
                    private boolean channelSelect;
                    private boolean channelStop;
                    private boolean select;

                    public boolean isChannelAdd() {
                        return channelAdd;
                    }

                    public void setChannelAdd(boolean channelAdd) {
                        this.channelAdd = channelAdd;
                    }

                    public boolean isChannelSelect() {
                        return channelSelect;
                    }

                    public void setChannelSelect(boolean channelSelect) {
                        this.channelSelect = channelSelect;
                    }

                    public boolean isChannelStop() {
                        return channelStop;
                    }

                    public void setChannelStop(boolean channelStop) {
                        this.channelStop = channelStop;
                    }

                    public boolean isSelect() {
                        return select;
                    }

                    public void setSelect(boolean select) {
                        this.select = select;
                    }
                }

                public static class IpcBean {
                    /**
                     * cloudVideo : true
                     * localVideo : true
                     * preview : true
                     * ptzCruise : true
                     * ptzCtrl : true
                     * ptzPreset : true
                     * select : true
                     * update : true
                     */

                    private boolean cloudVideo;
                    private boolean localVideo;
                    private boolean preview;
                    private boolean ptzCruise;
                    private boolean ptzCtrl;
                    private boolean ptzPreset;
                    private boolean select;
                    private boolean update;

                    public boolean isCloudVideo() {
                        return cloudVideo;
                    }

                    public void setCloudVideo(boolean cloudVideo) {
                        this.cloudVideo = cloudVideo;
                    }

                    public boolean isLocalVideo() {
                        return localVideo;
                    }

                    public void setLocalVideo(boolean localVideo) {
                        this.localVideo = localVideo;
                    }

                    public boolean isPreview() {
                        return preview;
                    }

                    public void setPreview(boolean preview) {
                        this.preview = preview;
                    }

                    public boolean isPtzCruise() {
                        return ptzCruise;
                    }

                    public void setPtzCruise(boolean ptzCruise) {
                        this.ptzCruise = ptzCruise;
                    }

                    public boolean isPtzCtrl() {
                        return ptzCtrl;
                    }

                    public void setPtzCtrl(boolean ptzCtrl) {
                        this.ptzCtrl = ptzCtrl;
                    }

                    public boolean isPtzPreset() {
                        return ptzPreset;
                    }

                    public void setPtzPreset(boolean ptzPreset) {
                        this.ptzPreset = ptzPreset;
                    }

                    public boolean isSelect() {
                        return select;
                    }

                    public void setSelect(boolean select) {
                        this.select = select;
                    }

                    public boolean isUpdate() {
                        return update;
                    }

                    public void setUpdate(boolean update) {
                        this.update = update;
                    }
                }
            }

            public static class DistrictAuthBean {
                /**
                 * device : {"move":true,"select":true}
                 * node : {"create":true,"delete":true,"move":true,"select":true,"update":true}
                 */

                private DeviceBean device;
                private NodeBean node;

                public DeviceBean getDevice() {
                    return device;
                }

                public void setDevice(DeviceBean device) {
                    this.device = device;
                }

                public NodeBean getNode() {
                    return node;
                }

                public void setNode(NodeBean node) {
                    this.node = node;
                }

                public static class DeviceBean {
                    /**
                     * move : true
                     * select : true
                     */

                    private boolean move;
                    private boolean select;

                    public boolean isMove() {
                        return move;
                    }

                    public void setMove(boolean move) {
                        this.move = move;
                    }

                    public boolean isSelect() {
                        return select;
                    }

                    public void setSelect(boolean select) {
                        this.select = select;
                    }
                }

                public static class NodeBean {
                    /**
                     * create : true
                     * delete : true
                     * move : true
                     * select : true
                     * update : true
                     */

                    private boolean create;
                    private boolean delete;
                    private boolean move;
                    private boolean select;
                    private boolean update;

                    public boolean isCreate() {
                        return create;
                    }

                    public void setCreate(boolean create) {
                        this.create = create;
                    }

                    public boolean isDelete() {
                        return delete;
                    }

                    public void setDelete(boolean delete) {
                        this.delete = delete;
                    }

                    public boolean isMove() {
                        return move;
                    }

                    public void setMove(boolean move) {
                        this.move = move;
                    }

                    public boolean isSelect() {
                        return select;
                    }

                    public void setSelect(boolean select) {
                        this.select = select;
                    }

                    public boolean isUpdate() {
                        return update;
                    }

                    public void setUpdate(boolean update) {
                        this.update = update;
                    }
                }
            }
        }
    }
}
