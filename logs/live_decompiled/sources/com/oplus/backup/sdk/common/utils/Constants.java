package com.oplus.backup.sdk.common.utils;

/* loaded from: classes.dex */
public class Constants {

    public static final class DataMigration {
        public static final int MSG_FROM_CLIENT = 1;
        public static final int MSG_TO_CLIENT = 2;
        public static final String SOURCE_FOLDERS = "source_folders";
        public static final String SPLIT_TAG = ";";
        public static final String TATGET_FOLDERS = "target_folders";
    }

    public static final class LoadBundle {
        public static final String BR_TYPE = "br_type";
        public static final int BR_TYPE_BACKUP = 0;
        public static final int BR_TYPE_RESTORE = 1;
        public static final String PLUGINS = "plugins";
    }

    public static final class MessagerConstants {
        public static final String ARGS_KEY = "args";
        public static final int ASYNC = 0;
        public static final String CONFIG_KEY = "config";
        public static final int HANDLE_INTENT_MSG = 0;
        public static final String INTENT_BACKUP_APP_DATA = "backup_app_data";
        public static final String INTENT_BACKUP_DST_FOLDER = "backup_dst_folder";
        public static final String INTENT_BACKUP_RESTORE_APP_DATA_RESULT = "backup_restore_app_data_result";
        public static final String INTENT_BACKUP_SRC_FOLDER = "backup_src_folder";
        public static final String INTENT_FD_KEY = "file_descriptor";
        public static final String INTENT_GET_FD = "get_file_descriptor";
        public static final String INTENT_GET_FD_FILE_FLAG = "file_flag";
        public static final String INTENT_GET_FD_FILE_PATH = "file_path";
        public static final String INTENT_INSTALL_APP = "install_app";
        public static final String INTENT_INSTALL_APP_FILE_PATH = "install_app_file";
        public static final String INTENT_INSTALL_APP_FLAG = "install_app_flag";
        public static final String INTENT_INSTALL_APP_PACKAGENAME = "install_app_package_name";
        public static final String INTENT_INSTALL_APP_RESULT = "install_app_result";
        public static final String INTENT_INVOKE_PLUGIN_METHOD = "invoke_plugin_method";
        public static final String INTENT_INVOKE_PLUGIN_METHOD_ARGS = "invoke_plugin_method_args";
        public static final String INTENT_INVOKE_PLUGIN_METHOD_NAME = "invoke_plugin_method_name";
        public static final String INTENT_INVOKE_PLUGIN_METHOD_PLUGIN_ID = "invoke_plugin_method_plugin_id";
        public static final String INTENT_INVOKE_PLUGIN_METHOD_RESULT = "invoke_plugin_method_result";
        public static final String INTENT_KEY = "intent";
        public static final String INTENT_RESTORE_APP_DATA = "restore_app_data";
        public static final String INTENT_RESTORE_DST_FOLDER = "restore_dst_folder";
        public static final String INTENT_RESTORE_SRC_FOLDER = "restore_src_folder";
        public static final String INTENT_RESTORE_TAR = "restore_tar";
        public static final String INTENT_RESTORE_TAR_APP_DATA_DST_FOLDER = "restore_tar_app_data_dst_folder";
        public static final String INTENT_RESTORE_TAR_EXCLUDE_ARGS = "restore_tar_exclude_agrs";
        public static final String INTENT_RESTORE_TAR_FILE = "restore_tar_file";
        public static final String INTENT_RESTORE_TAR_PACKAGE = "restore_tar_package";
        public static final String INTENT_RESTORE_TAR_RESULT = "restore_tar_result";
        public static final String INTENT_TAR = "tar";
        public static final String INTENT_TAR_EXCLUDE_ARGS = "tar_exclude_agrs";
        public static final String INTENT_TAR_FILE = "tar_file";
        public static final String INTENT_TAR_RESULT = "tar_result";
        public static final String INTENT_TAR_SOURCE_FOLDER = "tar_source_folder";
        public static final int METHOD_ID_BACKUP = 7;
        public static final int METHOD_ID_CANCEL = 11;
        public static final int METHOD_ID_CONTINUE = 10;
        public static final int METHOD_ID_CREATE = 5;
        public static final int METHOD_ID_DESTROY = 12;
        public static final int METHOD_ID_ERROR = 4;
        public static final int METHOD_ID_HANDLE_MSG = 2;
        public static final int METHOD_ID_INVOKE = 1;
        public static final int METHOD_ID_LOAD = 0;
        public static final int METHOD_ID_PAUSE = 9;
        public static final int METHOD_ID_PREPARE_BACKUP = 6;
        public static final int METHOD_ID_PREVIEW = 13;
        public static final int METHOD_ID_RECEIVE_MSG = 2;
        public static final int METHOD_ID_RESTORE = 8;
        public static final int METHOD_ID_UPDATE_PROGRESS = 3;
        public static final int METHOD_ID_UPDATE_PROTECT_TIME = 14;
        public static final String METHOD_KEY = "method";
        public static final String PARAMS_KEY = "params";
        public static final String PATH_KEY = "path";
        public static final String RETURN_KEY = "return";
        public static final int SYNC = 1;
    }

    public static final class PluginClass {
        public static final int BACKUP_PLUGIN_INDEX = 0;
        public static final int RESTORE_PLUGIN_INDEX = 1;
    }
}
