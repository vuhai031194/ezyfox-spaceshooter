package com.tvd12.app.entity;

import com.tvd12.app.model.Position;
import com.tvd12.ezyfox.database.annotation.EzyCollection;
import com.tvd12.ezyfox.database.annotation.EzyCollectionId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EzyCollection
@NoArgsConstructor
@AllArgsConstructor
public class GameObjectPosition {
    @EzyCollectionId(composite = true)
    private Id id;
    private String player;
    private String objectName;
    private int objectType;
    private boolean visible;
    private Position position;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id {
        private String game;
        private long gameId;
        private int objectId;
    }
}
