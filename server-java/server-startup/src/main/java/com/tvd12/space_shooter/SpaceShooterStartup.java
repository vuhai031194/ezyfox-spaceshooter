package com.tvd12.space_shooter;

import com.tvd12.app.AppEntry;
import com.tvd12.app.AppEntryLoader;
import com.tvd12.ezyfoxserver.constant.EzyEventType;
import com.tvd12.ezyfoxserver.embedded.EzyEmbeddedServer;
import com.tvd12.ezyfoxserver.ext.EzyAppEntry;
import com.tvd12.ezyfoxserver.ext.EzyPluginEntry;
import com.tvd12.ezyfoxserver.setting.*;
import com.tvd12.plugin.PluginEntry;
import com.tvd12.plugin.PluginEntryLoader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpaceShooterStartup {

    private static final String ZONE_NAME = "space-shooter";
    private static final String APP_NAME = "space-shooter";
    private static final String PLUGIN_NAME = "space-shooter";

    public static void main(String[] args) throws Exception {
        EzyPluginSettingBuilder pluginSettingBuilder = new EzyPluginSettingBuilder()
                .name(PLUGIN_NAME)
                .addListenEvent(EzyEventType.USER_LOGIN)
                .entryLoader(DecoratedPluginEntryLoader.class);

        EzyAppSettingBuilder appSettingBuilder = new EzyAppSettingBuilder()
                .name(APP_NAME)
                .entryLoader(DecoratedAppEntryLoader.class);

        EzyZoneSettingBuilder zoneSettingBuilder = new EzyZoneSettingBuilder()
                .name(ZONE_NAME)
                .application(appSettingBuilder.build())
                .plugin(pluginSettingBuilder.build());

        EzyWebSocketSettingBuilder webSocketSettingBuilder = new EzyWebSocketSettingBuilder()
                .active(false);

        EzyUdpSettingBuilder udpSettingBuilder = new EzyUdpSettingBuilder()
                .active(true);

        EzySessionManagementSettingBuilder sessionManagementSettingBuilder = new EzySessionManagementSettingBuilder()
                .sessionMaxRequestPerSecond(
                        new EzySessionManagementSettingBuilder.EzyMaxRequestPerSecondBuilder()
                            .value(250)
                            .build()
                );

        EzySimpleSettings settings = new EzySettingsBuilder()
                .zone(zoneSettingBuilder.build())
                .websocket(webSocketSettingBuilder.build())
                .udp(udpSettingBuilder.build())
                .sessionManagement(sessionManagementSettingBuilder.build())
                .build();

        EzyEmbeddedServer server = EzyEmbeddedServer.builder()
                .settings(settings)
                .build();
        server.start();
    }

    public static class DecoratedPluginEntryLoader extends PluginEntryLoader {

        @Override
        public EzyPluginEntry load() throws Exception {
            return new PluginEntry() {

                @Override
                protected String getConfigFile(EzyPluginSetting setting) {
                    return Paths.get(getPluginPath(setting), "config", "config.properties")
                            .toString();
                }

                private String getPluginPath(EzyPluginSetting setting) {
                    Path pluginPath = Paths.get("server-plugin");
                    if(!Files.exists(pluginPath))
                        pluginPath = Paths.get("../server-plugin");
                    return pluginPath.toString();
                }
            };
        }
    }

    public static class DecoratedAppEntryLoader extends AppEntryLoader {

        @Override
        public EzyAppEntry load() throws Exception {
            return new AppEntry() {

                @Override
                protected String getConfigFile(EzyAppSetting setting) {
                    return Paths.get(getAppPath(), "config", "config.properties")
                            .toString();
                }

                private String getAppPath() {
                    Path pluginPath = Paths.get("server-app-entry");
                    if(!Files.exists(pluginPath))
                        pluginPath = Paths.get("../server-app-entry");
                    return pluginPath.toString();
                }
            };
        }
    }
}