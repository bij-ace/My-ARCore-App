package com.a711.bshre032.myarapp;

import android.util.Log;

import com.google.ar.core.Config;
import com.google.ar.core.Session;
import com.google.ar.sceneform.ux.ArFragment;

public class CustomArFragment extends ArFragment {

    @Override
    protected Config getSessionConfiguration(Session session) {
        getPlaneDiscoveryController().setInstructionView(null);
        Config config = super.getSessionConfiguration(session);
//        config.setUpdateMode(Config.UpdateMode.LATEST_CAMERA_IMAGE);
        config.setCloudAnchorMode(Config.CloudAnchorMode.ENABLED);
        session.configure(config);
        this.getArSceneView().setupSession(session);

        if (((MainActivity)getActivity()).setupAugmentedImageDb(config, session)){
            Log.d("SetupAugImgDb", "Success");
        }
        else {
            Log.e("SetupAugImgDb", "Failed to setup Db");
        }
        return config;

//        getPlaneDiscoveryController().setInstructionView(null);
//        Config config = super.getSessionConfiguration(session);
//        config.setCloudAnchorMode(Config.CloudAnchorMode.ENABLED);
//        return config;
    }

}
