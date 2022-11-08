package org.wildfly.installationmanager.spi;

import org.wildfly.installationmanager.Channel;
import org.wildfly.installationmanager.HistoryResult;
import org.wildfly.installationmanager.ArtifactChange;

import java.util.Collection;
import java.util.List;

public interface InstallationManager {
    /**
     * Return all changes from the managed server history.
     *
     * @return
     * @throws Exception
     */
    List<HistoryResult> history() throws Exception;

    /**
     * Return description of a changes with if {@code revision} from the managed server history.
     *
     * @return
     * @throws Exception
     */
    List<ArtifactChange> revisionDetails(String revision) throws Exception;


    /**
     * Performs update of the server installation.
     * If no updates are found, this operation does nothing.
     *
     * @throws Exception
     */
    void update() throws Exception;

    /**
     * Lists updates available for the server installation.
     *
     * @return list of {@code ArtifactChange} available for update
     *
     * @throws Exception
     */
    List<ArtifactChange> findUpdates() throws Exception;

    /**
     * Lists channels the server installation is subscribed to.
     * If the servers is not subscribed to any channels, empty list is returned.
     *
     * @return Collection of {@code Channel}
     * @throws Exception - if unable to read the installation metadata
     */
    Collection<Channel> listChannels() throws Exception;

    /**
     * Unsubscribes the server installation from a channel.
     *
     * @param channel - {@code Channel} to be removed.
     * @throws Exception - if unable to read the installation metadata, or the Channel index doesn't exist
     */
    void removeChannel(Channel channel) throws Exception;

    /**
     * Subscribe the server installation to a new channel.
     *
     * @param channel - new {@code Channel}
     * @throws Exception - if unable to read the installation metadata, or the Channel index doesn't exist
     */
    void addChannel(Channel channel) throws Exception;

    /**
     * Persists changes to a channel that the server installation is subscribed to.
     *
     * @param oldChannel
     * @param newChannel - modified {@code Channel} to be stored.
     * @throws Exception
     */
    public void changeChannel(Channel oldChannel, Channel newChannel) throws Exception;
}
