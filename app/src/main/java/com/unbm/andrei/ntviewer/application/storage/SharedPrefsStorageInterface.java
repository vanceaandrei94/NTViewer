package com.unbm.andrei.ntviewer.application.storage;

import com.unbm.andrei.ntviewer.models.User;

/**
 * Created by Andrei on 8/31/2017.
 */

interface SharedPrefsStorageInterface {

    void saveLoggedInUser(User user);

    User getLoggedInUser();

    void removeLoggedUser();

}
